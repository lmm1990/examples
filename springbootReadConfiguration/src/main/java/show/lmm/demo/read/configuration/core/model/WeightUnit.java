package show.lmm.demo.read.configuration.core.model;

import org.springframework.util.unit.DataUnit;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 重量单位
 *
 * @author 刘明明
 * @since 2022-02-24 15:57
 */
public enum WeightUnit {
    /**
     * 吨
     */
    T("T"),

    /**
     * 千克
     */
    kg("kg"),

    /**
     * 克
     */
    g("g"),

    /**
     * 毫克
     */
    mg("mg");

    private String name;

    public String getName() {
        return name;
    }

    WeightUnit(String name){
        this.name = name;
    }

    /**
     * 重量单位列表
     */
    private static Map<String,WeightUnit> weightUnits = new HashMap<>();

    static {
        for (WeightUnit item : values()){
            weightUnits.put(item.getName(),item);
        }
    }

    public static WeightUnit fromSuffix(String suffix) {
        if(!weightUnits.containsKey(suffix)){
            throw new IllegalArgumentException("Unknown weight unit suffix '" + suffix + "'");
        }
        return weightUnits.get(suffix);
    }
}
