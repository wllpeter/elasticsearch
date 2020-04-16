package com.example.demo.elastic;

import com.example.demo.dto.Library;
import com.example.demo.dto.Person;
import com.example.demo.repository.LibraryRepository;
import com.example.demo.repository.PersonRepository;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

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
