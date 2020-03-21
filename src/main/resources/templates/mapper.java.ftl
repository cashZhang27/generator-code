package ${package.Mapper};

import ${superMapperClassPackage};
import ${package.Entity}.${entity};

/**
 * ${table.mapperName!}.
 *
 * @author ${author}
 * @version ${cfg.version}
 * @since ${cfg.currentDate}
 */
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

}
</#if>
