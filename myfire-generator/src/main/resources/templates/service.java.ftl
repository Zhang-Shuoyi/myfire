package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

     /**
      * 新增
      */
     void add(${entity} request);

     /**
      * 删除
      */
     void del(${entity} request);

     /**
      * 编辑
      */
     void edit(${entity} request);

     /**
      * 详情
      */
     SysUser detail(${entity} request);

     /**
      * 分页
      */
     Page<${entity}> findPage(${entity} request);

     /**
      * 笔数
      */
     Long queryCount(${entity} request);

}
</#if>
