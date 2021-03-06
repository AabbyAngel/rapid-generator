<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.service.query;
import java.io.Serializable;
import cn.winner.beans.base.BaseQueryEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
<@getImport/>

<#include "/java_copyright.include">
<#include "/java_imports.include">
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("${className}QUERY")
public class ${className}QUERY extends BaseQueryEntity implements Serializable{
    private static final long serialVersionUID = 1L;

<#list table.columns as column>
    <#if column.columnNameLower != "id">
    @ApiModelProperty("${column.remarks!''}")
    <#if column.javaType?split(".")?last== "Date">
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    </#if>
    private ${column.javaType?split(".")?last} ${column.columnNameLower};
    </#if>

</#list>
}