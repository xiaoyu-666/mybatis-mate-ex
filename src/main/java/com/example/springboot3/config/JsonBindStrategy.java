package com.example.springboot3.config;

import com.example.springboot3.entity.StatusEnum;
import com.example.springboot3.entity.SysUserEntity;
import mybatis.mate.databind.IJsonBindStrategy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JsonBindStrategy implements IJsonBindStrategy {
    public interface Type {
        String departmentRole = "departmentRole";

    }

    @Override
    public Map<String, Function<Object, Map<String, Object>>> getStrategyFunctionMap() {
        return new HashMap<String, Function<Object, Map<String, Object>>>(16) {
            {
                // 注入虚拟节点，绑定部门角色信息
                put(Type.departmentRole, (obj) -> new HashMap(3) {{
                    SysUserEntity user = (SysUserEntity) obj;
                    put("statusText", StatusEnum.get(user.getIsDel()).getDesc());
                    put("departmentName", "研发部");
                    put("roleName", "经理");
                }});
            }
        };
    }
}
