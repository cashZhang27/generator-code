package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};

/**
* ${table.serviceName!}.
*
* @author ${author}
* @version ${version}
* @since ${date}
*/
<#if kotlin>
  interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
  public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

  }
</#if>
