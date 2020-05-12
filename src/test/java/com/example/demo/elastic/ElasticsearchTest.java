package com.example.demo.elastic;

import com.example.demo.dto.Library;
import com.example.demo.dto.Person;
import com.example.demo.dto.User;
import com.example.demo.repository.LibraryRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.UserRepository;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Iterator;

/**
 * @Date 2020/4/16 10:37
 * @Author 86131
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchTest {


    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    LibraryRepository libraryRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    UserRepository userRepository;

    /**
     * 插入数据
     */
    @Test
    public void testInsert() {
        libraryRepository.save(new Library(42, "A00042", "明史简述", 59, "吴晗", "吴晗背景uniworsity厉害"));
        libraryRepository.save(new Library(43, "A00043", "傅雷家书", 99, "傅聪", "都是NB，class大家u"));
        libraryRepository.save(new Library(24, "A00942", "时间简史", 169, "霍金", "教授宇宙大爆发的59年历史"));
        libraryRepository.save(new Library(25, "A00925", "我的前半生", 39, "方舟89子", "都是生活，每晚9点"));
        libraryRepository.save(new Library(29, "A00029", "围9城", 139, "钱钟书", "你想出城？不存在的"));
    }

    @Test
    public void testInsertPerson() {
        personRepository.save(new Person(10010, "吴晗", 38));
        personRepository.save(new Person(10011, "傅聪", 54));
        personRepository.save(new Person(10012, "霍金", 28));
        personRepository.save(new Person(10013, "方舟89子", 39));
        personRepository.save(new Person(10014, "钱钟书", 43));
    }

    @Test
    public void testInsertUser() {
        userRepository.save(new User(3, "高新兴", "gao45", 18, "我登录的ip地址是：127.145.0.11", new Date()));
        userRepository.save(new User(4, "神州@数码", "shen18", 18, "我登录的ip地址是：127.124.0.11", new Date()));
        userRepository.save(new User(6, "西南大学", "xida", 18, "我登录的ip地址是：127.126.0.11", new Date()));
        userRepository.save(new User(7, "北京大学", "beida", 18, "我记录的ip地址是：127.127.0.11", new Date()));
        userRepository.save(new User(8, "姚#明", "yao210", 18, "我登录的@#%ip地址是：127.248.0.11", new Date()));
        userRepository.save(new User(9, "邓紫棋", "dengml", 18, "我使用的ip地址是：127.249.0.11", new Date()));
        userRepository.save(new User(10, "李荣浩", "li06", 18, "我使用的@ip地址是：127.234.0.11", new Date()));
        userRepository.save(new User(11, "陈奕迅", "19ch8en", 18, "我登录的ip地址是：127.219.0.11", new Date()));
        userRepository.save(new User(12, "周杰伦", "xiayu2014", 18, "我登录的ip地址是：127.0.0.11", new Date()));
        userRepository.save(new User(13, "林俊杰", "zho99", 18, "我登录,的ip地址是：127.111.0.11", new Date()));
        userRepository.save(new User(137, "林薇因", "zho99", 18, "我登录,的ip地址是：127.111.0.11", new Date()));
    }

    @Test
    public void testQueryByStr() {
        try {
            String searchStr = "陈夏天u马立,@45";
            QueryStringQueryBuilder builder = new QueryStringQueryBuilder(searchStr);

            //  重点是下面这行代码
            builder.analyzer("myanalyzer").field("username").field("password").field("ip");
            Iterable<User> search = userRepository.search(builder);
            Iterator<User> iterator = search.iterator();
            while (iterator.hasNext()) {
                System.out.println("---> 匹配数据： " + iterator.next());
            }
        } catch (Exception e) {
            System.out.println("---> 异常信息 " + e);
        }
    }


    // 全字段查询,不分页
    @Test
    public void testSearch() {
        try {
            String searchStr = "时间";
            QueryStringQueryBuilder builder = new QueryStringQueryBuilder(searchStr);
            Iterable<Library> search = libraryRepository.search(builder);
            Iterator<Library> iterator = search.iterator();
            while (iterator.hasNext()) {
                System.out.println("--> 数据：" + iterator.next());
            }
        } catch (Exception e) {
            System.out.println("---> 异常信息： " + e);
        }
    }

    // 全字段查询, 已经分页
    @Test
    public void testSearchByPage() {
        try {
            String searchStr = "时间";
            QueryStringQueryBuilder builder = new QueryStringQueryBuilder(searchStr);
            Iterable<Library> search = libraryRepository.search(builder, PageRequest.of(0, 2));
            Iterator<Library> iterator = search.iterator();
            while (iterator.hasNext()) {
                System.out.println("--> 数据：" + iterator.next());
            }
        } catch (Exception e) {
            System.out.println("---> 异常信息： " + e);
        }
    }

}
