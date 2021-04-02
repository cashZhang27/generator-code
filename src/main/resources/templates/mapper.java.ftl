package ${package.Mapper};

import ${superMapperClassPackage};
import ${package.Entity}.${entity};

/**
 * ${table.mapperName!}.
 *
 * @author ${author}
 * @version ${cfg.version} ${cfg.currentDate}
 * @since ${cfg.version}
 */
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

}
</#if>
