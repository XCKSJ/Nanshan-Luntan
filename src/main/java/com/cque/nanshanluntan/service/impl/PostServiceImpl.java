package com.cque.nanshanluntan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cque.nanshanluntan.domain.Post;
import com.cque.nanshanluntan.mapper.PostMapper;
import com.cque.nanshanluntan.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {
}
