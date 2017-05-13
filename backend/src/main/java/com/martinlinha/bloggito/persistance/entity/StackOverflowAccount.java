package com.martinlinha.bloggito.persistance.entity;

import javax.persistence.Embeddable;

/**
 * Created by martinlinha on 13.05.17.
 */
@Embeddable
public class StackOverflowAccount {

    private Integer points;
    private Integer gold;
    private Integer silver;
    private Integer bronze;

    private Long stackOverflowId;

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public Integer getSilver() {
        return silver;
    }

    public void setSilver(Integer silver) {
        this.silver = silver;
    }

    public Integer getBronze() {
        return bronze;
    }

    public void setBronze(Integer bronze) {
        this.bronze = bronze;
    }

    public Long getStackOverflowId() {
        return stackOverflowId;
    }

    public void setStackOverflowId(Long stackOverflowId) {
        this.stackOverflowId = stackOverflowId;
    }
}
