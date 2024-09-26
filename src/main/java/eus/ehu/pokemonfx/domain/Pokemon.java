package eus.ehu.pokemonfx.domain;

import com.google.gson.annotations.SerializedName;

public class Pokemon {

    private String name;
    private Integer height;
    private Integer weight;
    private Integer id;

    
    public String getSprite() {
        return sprites.other.officialArtwork.front_default;
    }

    public String getName() {
        return name;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getId() {
        return id;
    }

    class SpriteWrapper {
        String front_default;
        String back_default;
        String front_shiny;
        String back_shiny;
        class Other {
            class Official {
                String front_default;

                @Override
                public String toString() {
                    return "Official{" +
                            "front_default='" + front_default + '\'' +
                            '}';
                }
            }
            @SerializedName("official-artwork")
            Official officialArtwork;

            @Override
            public String toString() {
                return "Other{" +
                        "officialArtwork=" + officialArtwork +
                        '}';
            }

        }
        Other other;

        @Override
        public String toString() {
            return "SpriteWrapper{" +
                    "back_default='" + back_default + '\'' +
                    ", front_default='" + front_default + '\'' +
                    ", front_shiny='" + front_shiny + '\'' +
                    ", back_shiny='" + back_shiny + '\'' +
                    ", other=" + other +
                    '}';
        }
    }

    private SpriteWrapper sprites;

    @Override
    public String toString() {
        return "Pokemon{" +
                "height=" + height +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", id=" + id +
                ", sprites=" + sprites +
                '}';
    }
}
