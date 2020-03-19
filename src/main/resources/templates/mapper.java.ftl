package ${package.Mapper};

import ${package.Entity}.${entity};
import ${superMapperClassPackage};

/**
* ${table.mapperName!} Mapper.
*
* @author ${author}
* @version ${version}
* @since ${date}
*/
<#if kotlin>
  interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
  public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

  }
</#if>
