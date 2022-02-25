package show.lmm.demo.read.configuration.core.model;

/**
 * 重量
 *
 * @author 刘明明
 * @since 2022-02-24 15:57
 */
public class Weight {

    /**
     * 重量
     */
    private long weight;

    /**
     * 重量单位
     */
    private WeightUnit weightUnit;

    public Weight(long weight,WeightUnit weightUnit){
        this.weight = weight;
        this.weightUnit = weightUnit;
    }

    @Override
    public String toString() {
        return "Weight{" +
                "weight=" + weight +
                ", weightUnit=" + weightUnit +
                '}';
    }
}
