package com.how2java;
   
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
 
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
 
import com.how2java.mapper.ProductMapper;
import com.how2java.pojo.Product;
   
public class TestMybatis {
   
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        ProductMapper mapper = session.getMapper(ProductMapper.class);
 
        List<Product> ps= mapper.list();
        for (Product p : ps) {
            System.out.println(p + "\t��Ӧ�ķ�����:\t" + p.getCategory().getName());
        }
 
        session.commit();
        session.close();
   
    }
}