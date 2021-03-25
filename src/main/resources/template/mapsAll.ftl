package ${packageName}.<#if module!=null && module?length gt 0>${module?trim}.</#if>${dir?replace("/", ".")};

import ${packageName}.<#if module!=null && module?length gt 0>${module?trim}.</#if>entity.param.${tableInfo.tableNameCamelCase?lower_case}.${tableInfo.tableNameCamelCase}SaveUpdateParam;
import ${packageName}.<#if module!=null && module?length gt 0>${module?trim}.</#if>entity.po.${tableInfo.tableNameCamelCase};
import ${packageName}.<#if module!=null && module?length gt 0>${module?trim}.</#if>entity.vo.${tableInfo.tableNameCamelCase?lower_case}.${tableInfo.tableNameCamelCase}PageVO;
import ${packageName}.<#if module!=null && module?length gt 0>${module?trim}.</#if>entity.vo.${tableInfo.tableNameCamelCase?lower_case}.${tableInfo.tableNameCamelCase}VO;

import org.mapstruct.Mapper;
import java.util.List;

/**
 * @author chun
 * @date 2020/8/12 16:16
 */
@Mapper(componentModel = "spring")
public interface ${tableInfo.tableNameCamelCase}Maps {

    /**
     * saveUpdateParam转换po
     *
     * @param param the param
     * @return ${tableInfo.tableName?lower_case}
     */
    ${tableInfo.tableNameCamelCase} saveUpdateParamToPo(${tableInfo.tableNameCamelCase}SaveUpdateParam param);

    /**
     * Po to vo ${tableInfo.tableName?lower_case} vo.
     *
     * @param ${tableInfo.tableName?lower_case} the ${tableInfo.tableName?lower_case}
     * @return the ${tableInfo.tableName?lower_case} vo
     */
    ${tableInfo.tableNameCamelCase}VO poToVo(${tableInfo.tableNameCamelCase} ${tableInfo.tableNameCamelCase?uncap_first});

    /**
     * Po to page vo ${tableInfo.tableName?lower_case} page vo.
     *
     * @param ${tableInfo.tableName?lower_case} the ${tableInfo.tableName?lower_case}
     * @return the ${tableInfo.tableName?lower_case} page vo
     */
    ${tableInfo.tableNameCamelCase}PageVO poToPageVo(${tableInfo.tableNameCamelCase} ${tableInfo.tableNameCamelCase?uncap_first});

    /**
     * Po to page vo list.
     *
     * @param ${tableInfo.tableName?lower_case}s the ${tableInfo.tableName?lower_case}s
     * @return the list
     */
    List<${tableInfo.tableNameCamelCase}PageVO> poToPageVo(List<${tableInfo.tableNameCamelCase}> ${tableInfo.tableNameCamelCase?uncap_first}s);
}
