package EnumMonsters;
    public enum ObstaclesTypes {
        WITCH(SuperNaturalType.WITCH),
        FAIRY(SuperNaturalType.FAIRY),
        GOBLIN(SuperNaturalType.GOBLIN);

        SuperNaturalType superNaturalType;

        ObstaclesTypes(SuperNaturalType superNaturalType) {
            this.superNaturalType = superNaturalType;
        }

        public SuperNaturalType getSuperNaturalType() {
            return superNaturalType;
        }
    }
