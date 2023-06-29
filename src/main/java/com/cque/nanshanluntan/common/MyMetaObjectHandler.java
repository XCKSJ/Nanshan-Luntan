package com.cque.nanshanluntan.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 利用 myabtis plus 自动填充策略
 * 1、删除数据库时间自动的默认值
 * 2、在实体类的时间字段属性上增加注解
 *      1、createTime需要在实体类配置@TableField(fill = FieldFill.INSERT)
 *      2、updateTime需要在实体类配置@TableField(fill = FieldFill.INSERT_UPDATE)
 * 3、编写配置类来处理这个注解
 * @description：数据库自动插入时间工具类
 *
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    // 插入时填充策略
    public void insertFill(MetaObject metaObject) {
        System.out.println("添加插入时间");
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }

    // 修改时填充策略
    public void updateFill(MetaObject metaObject) {
        System.out.println("更新插入时间");
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
