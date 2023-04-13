public class Main {
    public static int bossHealth = 700;
    public static int bossDamage = 50;
    public static String bossDefence;
    public static int[] heroesHealth = {280, 270, 250, 300};
    public static int[] heroesDamage = {10, 15, 20, 0};
    public static String[] heroesAttackType = {"Physical", "Magical", "Kinetic", "Healer"};
    public static int roundNumber = 0;
    public static int[] heroesHealthBackup = {280, 270, 250, 300};
    public static boolean isThorStunned = false;
    public static void main(String[] args) {
        printStatistics();

        while (!isGameFinished()) {
            playRound();
        }
    }

    public static void chooseBossDefence() {
        Random random = new  random();
        int randomIndex = random.nextInt(heroesHealth.length);
        bossDefence = heroesAttackType[randomIndex];
    }

    public static void playRound() {
        roundNumber++;
        chooseBossDefence();
        if (isThorStunned) {
            System.out.println("Boss is stunned and cannot attack!");
            isThorStunned = false;
        } else {
            bossHits();
        }
        heroesHits();
        healHeroes();
        printStatistics();
    }

    public static void heroesHits() {
        for (int i = 0; i < heroesDamage.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                if (heroesAttackType[i].equals(bossDefence)) {
                    System.out.println(heroesAttackType[i] + " attack was blocked by Boss!");
                } else {
                    if (heroesAttackType[i].equals("Healer")) {
                        System.out.println("Healer is not attacking this turn.");
                    } else {
                        bossHealth -= heroesDamage[i];
                        System.out.println(heroesAttackType[i] + " attacked Boss with " + heroesDamage[i] + " damage");
                    }
                }
            }
        }
    }

    public static void bossHits() {
        int damage = bossDamage;
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                if (heroesAttackType[i].equals("Golem")) {
                    int golemDamage = bossDamage / 5;
                    heroesHealth[i] -= golemDamage;
                    damage -= golemDamage;
                }
                if (heroesAttackType[i].equals("Berserk")) {
                    int blockedDamage = bossDamage / 2;
                    heroesHealth[i] -= blockedDamage;
                    damage += blockedDamage;
                }
                if (heroesAttackType[i].equals("Lucky")) {
                    Random random = new random();
                    boolean isLucky = random.nextBoolean();
                    if (isLucky) {
                        System.out.println("Lucky dodged the Boss attack!");
                        continue;
                    }
                }
                heroesHealth[i] -= damage;
                System.out.println("Boss attacked " + heroesAttackType[i] + " with " + damage + " damage");
            }
        }
    }

    public static void healHeroes() {
        int maxHealthIndex = -1;
        int maxHealth = 0;
        int healerIndex = -1;
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0 && heroesHealth[i] < 100 && heroesHealth[i] > maxHealth) {
                maxHealth = heroes;

            }
        }
    }
