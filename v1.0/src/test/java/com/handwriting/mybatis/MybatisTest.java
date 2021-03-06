package com.handwriting.mybatis;

import com.handwriting.domain.Blog;
import com.handwriting.mapper.BlogMapper;

/**
 * @author ZhenZhong
 * @date 2020/5/13
 */
public class MybatisTest {

    public static void main(String[] args) {
        SqlSession sqlSession = new SqlSession(new Configuration());
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = mapper.selectByPrimaryKey(1);
        System.out.println(blog);
    }
}