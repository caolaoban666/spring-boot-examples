package com.test.service;

import com.baomidou.mybatisplus.service.IService;
import com.test.entity.major.TbLabelFormRelation;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zw
 * @since 2019-04-24
 */
public interface ITbLabelFormRelationService extends IService<TbLabelFormRelation> {

    public String delLabelForm(String id);

}
