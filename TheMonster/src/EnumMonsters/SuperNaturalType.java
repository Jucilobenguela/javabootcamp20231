package EnumMonsters;
public enum SuperNaturalType {
    WEREWOLF("Werewolf"),
    MUMMY("Mummy"),
    VAMPIRE("Vampire"),
    WITCH("Witch"),
    FAIRY("Fairy"),
    GOBLIN("Goblin");

    private final String description;

    private SuperNaturalType (String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
