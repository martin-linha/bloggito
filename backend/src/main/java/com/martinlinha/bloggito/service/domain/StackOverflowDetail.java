package com.martinlinha.bloggito.service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by martinlinha on 13.05.17.
 */
public class StackOverflowDetail {

    private Item[] items;

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    static public class Item {
        private int reputation;
        @JsonProperty("badge_counts")
        private BadgeCounts badgeCounts;

        public int getReputation() {
            return reputation;
        }

        public void setReputation(int reputation) {
            this.reputation = reputation;
        }

        public BadgeCounts getBadgeCounts() {
            return badgeCounts;
        }

        public void setBadgeCounts(BadgeCounts badgeCounts) {
            this.badgeCounts = badgeCounts;
        }
    }

    static public class BadgeCounts {
        private int bronze;
        private int silver;
        private int gold;

        public int getBronze() {
            return bronze;
        }

        public void setBronze(int bronze) {
            this.bronze = bronze;
        }

        public int getSilver() {
            return silver;
        }

        public void setSilver(int silver) {
            this.silver = silver;
        }

        public int getGold() {
            return gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }
    }
}
