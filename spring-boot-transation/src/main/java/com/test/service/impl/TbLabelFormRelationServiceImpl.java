package com.test.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.test.entity.major.TbLabelFormRelation;
import com.test.mapper.master.TbLabelFormRelationMapper;
import com.test.service.ITbLabelFormRelationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zw
 * @since 2019-04-24
 */
@Service
public class TbLabelFormRelationServiceImpl extends ServiceImpl<TbLabelFormRelationMapper, TbLabelFormRelation> implements ITbLabelFormRelationService {

    //    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    @Transactional
    public String delLabelForm(String id) {
        try {
            deleteById(id);
            int a = 5 / 0;
            System.out.println(a);
            delete(new EntityWrapper<>());
            deleteById("4");
        } catch (Exception e) {
            throw new RuntimeException("出现异常");
        }
        return null;
    }
}
