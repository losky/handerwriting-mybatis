package com.handwriting.mapper;

import com.handwriting.domain.Blog;

/**
 * @author ZhenZhong
 * @date 2020/5/13
 */
public interface BlogMapper {

    Blog selectByPrimaryKey(Integer id);
}
