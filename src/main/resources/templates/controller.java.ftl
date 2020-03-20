package ${package.Controller};


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
<#if entityLombokModel>
import lombok.AllArgsConstructor;
</#if>
import org.springframework.web.bind.annotation.RequestMapping;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
<#if swagger2>
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
</#if>
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${table.controllerName!}.
 *
 * @author ${author}
 * @version ${cfg.version}
 * @since ${cfg.currentDate}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
<#if entityLombokModel>
@AllArgsConstructor
</#if>
<#if swagger2>
@Api(tags = "")
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>s")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
    <#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
    <#else>
public class ${table.controllerName} {
    </#if>

  private ${table.serviceName} ${table.serviceName?uncap_first};

  @ApiOperation("创建")
  @PostMapping
  public void create(@RequestBody @Valid ${entity} ${entity?uncap_first}) {
    this.${table.serviceName?uncap_first}.save(${entity?uncap_first});
  }

  @DeleteMapping("/{id}")
  public boolean deleteById(@PathVariable("id") String id) {
    return this.${table.serviceName?uncap_first}.removeById(id);
  }

  @PutMapping("/{id}")
  @ApiOperation("根据ID修改")
  public boolean updateById(@PathVariable("id") String id, ${entity} ${entity?uncap_first}) {
    ${entity?uncap_first}.setId(id);
    return this.${table.serviceName?uncap_first}.updateById(${entity?uncap_first});
  }

  @ApiOperation("根据ID查询详情")
  @GetMapping("/{id}")
  public ${entity} findById(@PathVariable("id") String id) {
    return this.${table.serviceName?uncap_first}.getById(id);
  }
}
</#if>
