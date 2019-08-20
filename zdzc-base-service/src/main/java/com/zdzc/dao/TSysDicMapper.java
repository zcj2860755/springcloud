package com.zdzc.dao;

import com.zdzc.core.Mapper;
import com.zdzc.model.TSysDic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TSysDicMapper extends Mapper<TSysDic> {

    /**
     * @description：   查询所有 + 模糊查询
     * @author：李琳青
     * @date：2019-08-07 13:18
     */
    List<TSysDic> selectAllDic(TSysDic tSysDic);

    /**
     * @description： 根据categoryId查询出数据字典
     * @author：李琳青
     * @date：2019-08-07 13:18
     */
    TSysDic selectTSysDicWithCatergory(@Param("id") String id);

    /**
     * @description： 根据categoryId查询出小类的数量
     * @author：李琳青
     * @date：2019-08-07 13:18
     */
    int selectDicCountByCategoryId(@Param("categoryId") String categoryId);

    /**
     * @description： categoryId + key 查询
     * @author：李琳青
     * @date：2019-08-07 13:18
     */
    List<TSysDic> selectListBykeyAndCategory(TSysDic tSysDic);


}