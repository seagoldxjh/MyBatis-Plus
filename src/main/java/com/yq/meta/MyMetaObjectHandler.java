package com.yq.meta;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

public class MyMetaObjectHandler  implements MetaObjectHandler {


    //增加时，给没有赋值的字段   加默认值
    @Override
    public void insertFill(MetaObject metaObject) {
        System.out.println( ("start insert fill ...."));
        //column
        this.setInsertFieldValByName("stuName", "ZHang", metaObject);//@since 快照：3.0.7.2-SNAPSHOT， @since 正式版暂未发布3.0.7
    }
    //更新时，给没有赋值的字段   加默认值
    @Override
    public void updateFill(MetaObject metaObject) {
        System.out.println( ("start update fill ...."));
        this.setUpdateFieldValByName("stuName", "LISI", metaObject);//@since 快照：3.0.7.2-SNAPSHOT， @since 正式版暂未发布3.0.7
    }
}
