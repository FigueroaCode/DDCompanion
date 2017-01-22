package Models;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
public class Character {
	private int str;
	private int intelli;
	private int dex;
	private int consti;
	private int wis;
	private int charisma;

    private String keyId;
	private String name;
	private String race;
	private String profession;
    private String alignment;
    private String trait;
    private String flaw;
    private String bond;
    private String ideals;
    private String background;

    private int wealth;
    private int hitPoints;
    private int maxHP;
    private int level;
    private int hitDie;
    private int exp;
    private int proficiencyBonus;
    private int initiative;
    private int armorClass;
    private int speed;

    public Character(String alignment, String bond,
                     int exp, String flaw, String ideals, int level, String name,
                     String profession, String race,String trait,String background,String keyId) {
        this.alignment = alignment;
        this.bond = bond;
        this.exp = exp;
        this.flaw = flaw;
        this.ideals = ideals;
        this.level = level;
        this.name = name;
        this.profession = profession;
        this.race = race;
        this.trait = trait;
        this.background = background;
        this.keyId = keyId;

        str = 0;
        intelli = 0;
        dex = 0;
        consti = 0;
        wis = 0;
        charisma = 0;
        wealth = 0;
        proficiencyBonus = 0;
        initiative = 0;
        armorClass = 0;
        speed = 0;

    }



	//ArrayList for Languages and profencies
	ArrayList<String> languages = new ArrayList<String>();
	ArrayList<String> proficiencies = new ArrayList<String>();
	//Create ArrayList for equipment and show equipment
	ArrayList<String> equipment = new ArrayList<String>();
	
	//Create ArrayList for spells, Cantrips, level 1 and level 2..etc.
	ArrayList<String> spells = new ArrayList<String>();
		//A Long_Rest method that resets spell count
		//Counter to count number of times spell has been casted...Cast spell method
	//Constructor for the character
	public Character(String name, String race){
		str = 0;
		intelli = 0;
		dex = 0;
		consti= 0;
		wis = 0;
		charisma = 0;
		wealth = 0;
		hitPoints = 0;
		hitDie = 0;
		exp = 0;
		initiative = 0;
		this.name = name;
		this.race = race;
		profession = "";
	}
	//Getters and Setters


    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getBackground() {
        return background;
    }

    public int getStr(){
		return str;
	}
	public int getIntelli(){
		return intelli;
	}
	public int getDex(){
		return dex;
	}
	public int getConsti(){
		return consti;
	}
	public int getWis(){
		return wis;
	}
	public int getCharisma(){
		return charisma;
	}
	public String getName(){
		return name;
	}
	public void setProfession(String profession){
		this.profession = profession;
	}
	public String getProfession() {
		return profession;
	}
	public int getWealth(){
		return wealth;
	}
	public int getExp(){
		return exp;
	}

    public int getMaxHP() {
        return maxHP;
    }

    public String getAlignment() {
        return alignment;
    }

    public String getBond() {
        return bond;
    }

    public String getFlaw() {
        return flaw;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public String getIdeals() {
        return ideals;
    }

    public int getLevel() {
        return level;
    }

    public String getRace() {
        return race;
    }

    public String getTrait() {
        return trait;
    }

//    public ArrayList<String> addSpells(ArrayList<String> spells,int count){
//		for(int i = 0; i <= count; i++){
//			spells.add(count);
//		}
//		return spells;
//	}
//	public ArrayList<String> addEquipment(ArrayList<String> equipment, int count){
//		for(int i = 0; i <= count; i++){
//			equipment.add(count);
//		}
//		return equipment;
//	}
//	public ArrayList<String> addProficiences(ArrayList<String> proficiences,int count){
//		for(int i = 0; i <= count; i++){
//			proficiencies.add(input.next());
//		}
//		return proficiencies;
//	}
//	public ArrayList<String> addLanguages(ArrayList<String> languages, int count){
//		for(int i = 0; i <= count; i++){
//			languages.add(input.next());
//		}
//		return languages;
//	}
//	public ArrayList<String> removeSpells(ArrayList<String> spells, int count){
//		for(int i = 0; i <= count; i++){
//			spells.remove(input.next());
//		}
//		return spells;
//	}
//	public ArrayList<String> removeEquipment(ArrayList<String> equipment, int count){
//		for(int i = 0; i <= count; i++){
//			equipment.remove(input.next());
//		}
//		return equipment;
//	}
	
	public boolean short_Rest(){
	int hpGained = (int) (Math.random() * hitDie + 1);
	//Giving the user choice of using their hit die count, based on their level
	//Counter for Hit Dice
	if(hpGained > maxHP){
		hitPoints = maxHP;
		return true;
	}
	else{
		hitPoints =+ hpGained;
	}
	System.out.println("You gained " + hpGained + "hit points");
	return true;
	}
//	public boolean long_Rest(){
//		//Regains lost hit points and gets hit dice equal to half their level
//		hitPoints = maxHP;
//		//Spells can be chosen again, reprompt user to select spells
//		//Counter for spells
//		spells.clear();
//		addSpells(spells, input);
//		return true;
//	}
//
	//Add Experience Points
	public int addXP(int newXP){
		exp =+ newXP;
		return exp;
	}
//	public boolean checkAC(Scanner input){
//		System.out.println("What type of armor do you have? Light, Medium, or Heavy?");
//		String armorType = input.next();
//		if(armorType.equalsIgnoreCase("Light")){
//			armorClass = 11 + checkModifier(dex);
//			return true;
//		}
//		else if(armorType.equalsIgnoreCase("Medium")){
//			armorClass = 14 + checkModifier(dex);
//			return true;
//		}
//		else if (armorType.equalsIgnoreCase("Heavy")){
//			armorClass = 15;
//			return true;
//		}
//		else{
//			return false;
//		}
//	}
//	public boolean checkLevel(Scanner input){
//		System.out.println("What level is your character based on their experience?");
//		level = input.nextInt();
//		System.out.println("You are level: " + level);
//		return true;
//	}
	
	//Calculte profiency bonus of character
	public boolean checkProficiency(){
		if(level <= 4){
			proficiencyBonus = 2;
			return true;
		}
		else if((level <= 8) && (level >= 5)){
			proficiencyBonus = 3;
			return true;
		}
		else if((level <= 12) && (level >= 9)){
			proficiencyBonus = 3;
			return true;
		}
		else if((level <= 13) && (level >= 16)){
			proficiencyBonus = 3;
			return true;
		}
		else if((level <= 17) && (level >= 20)){
			proficiencyBonus = 3;
			return true;
		}
		else{
			return false;
		}
	}
	public int addHP(int newHP){
		hitPoints =+ newHP;
		return hitPoints;
	}
	public int loseHP(int newHP){
		hitPoints =- newHP;
		return hitPoints;		
	}
	public boolean addRaceStats() {
		//Adds Ability Score modifiers to character given their race
		//Series of If/Else Statements 
		if(race.equalsIgnoreCase("Human")){
			str =+ 1;
			intelli =+ 1;
			dex =+ 1;
			consti =+ 1;
			wis =+ 1;
			charisma =+ 1;
			return true;
		}
		else if(race.equalsIgnoreCase("Halfling")){
			dex =+ 2;
			return true;
		}
		else if(race.equalsIgnoreCase("Elf")){
			dex =+ 2;
			return true;
		}
		else if(race.equalsIgnoreCase("Dwarf")){
			consti =+ 2;
			return true;
		}
		else if(race.equalsIgnoreCase("Tiefling")){
			intelli =+ 1;
			charisma =+ 2;
			return true;
		}
		else
		return false;
	}
	//Adds HP and Wealth for Charcacters given their class
	public void addHPAndWealth() {
		if(profession.equalsIgnoreCase("Fighter")){
			for(int i = 0; i <= 5; i++){
				wealth =+ (int) Math.random() * 4 + 1;
			}
			wealth = wealth*10;
			maxHP = 10 + checkModifier(consti);
			hitDie = 10;
		}
		else if(profession.equalsIgnoreCase("Wizard")){
			for(int i = 0; i <= 4; i++){
				wealth =+ (int) Math.random() * 4 + 1;
			}
			wealth = wealth*10;
			maxHP = 6 + checkModifier(consti);
			hitDie = 6;
		}
		else if(profession.equalsIgnoreCase("Rogue")){
			for(int i = 0; i <= 4; i++){
				wealth =+ (int) Math.random() * 4 + 1;
			}
			wealth = wealth*10;
			maxHP = 8+ checkModifier(consti);
			hitDie = 8;
		}
		else if(profession.equalsIgnoreCase("Cleric")){
			for(int i = 0; i <= 5; i++){
				wealth =+ (int) Math.random() * 4;
			}
			wealth = wealth*10;
			maxHP = 8 + checkModifier(consti);
			hitDie = 8;
		}
		else{
			maxHP = 5;
            hitDie = 5;
		}

        hitPoints = maxHP;
	}
//	public void createStats(Scanner input){
//		System.out.println("How would you like to create ability Scores?");
//		System.out.print("(Random(1), stanard set(2), Point Buy(3))");
//		int createMethod = input.nextInt();
//		if(createMethod == 1){
//
//		}
//		System.out.println("Now, rolling dice, will choose"
//				+ " highest of 4 rolls");
//
//
//	}
	public void randomStats() {
		int[] points = new int[4];
		int sum;
		for(int i = 0; i <= 4; i++) {
			points[i] = (int) (Math.random() * 6) + 1;
			if(points[i] > points[i-1]){
				sum =+ points[i];
			}
		}
//		System.out.println(sum);
	}
//	//Uses user input to apply stats to various Ability Scores
//	public void standardSet(Scanner input){
//	while(true) {
//		System.out.println("Strength: 0");
//		System.out.println("Intelligence: 0");
//		System.out.println("Dexterity: 0");
//		System.out.println("Constiution: 0");
//		System.out.println("Charisma: 0");
//		System.out.println("Wisdom: 0");
//		System.out.println(" Use 15, 14, 13, 12, 10, and 8 to apply to your"
//				+ " stats");
//		str = input.nextInt();
//		intelli = input.nextInt();
//		dex = input.nextInt();
//		consti = input.nextInt();
//		charisma = input.nextInt();
//		wis = input.nextInt();
//		System.out.println("You're stats are as follows: ");
//		System.out.println("Strength: " +getStr());
//		System.out.println("Intelligence: " + getIntelli());
//		System.out.println("Dexterity: " + getDex());
//		System.out.println("Constiution: " + getConsti());
//		System.out.println("Charisma: " + getCharisma());
//		System.out.println("Wisdom: " + getWis());
//		System.out.println("Do you want to continue(1) or redo(2)?");
//		if(input.nextInt() == 1) {
//			break;
//		}
//	}
		
	//}
	public int checkModifier(int stat){
//p.10 of Handbook
//Checks if Ability Score causes a modifier
		if(stat == 6 || stat == 7){
			return -2;
		}
		else if(stat == 8 || stat == 9){
			return -1;
		}
		else if(stat == 10 || stat == 11){
			return 0;
		}
		else if(stat == 12 || stat == 13){
			return +1;
		}
		else if(stat == 14 || stat == 15){
			return +2;
		}
		else if(stat == 16 || stat == 17){
			return +3;
		}
		else if(stat == 18 || stat == 19){
			return +4;
		}
		return 0;
	}
//
//	public void toWrite(){
//		//Writes information about character object into a file with the character's name
//		File file = new File(getName() + ".txt");
//	try{
//		PrintWriter outPut = new PrintWriter(file);
//		outPut.println("Name: " + getName());
//		outPut.println("Class: " + getProfession());
//		outPut.println("Wealth: " + getWealth());
//		outPut.println("Hit points: " + getHP());
//		outPut.println("-------");
//		outPut.println("You're stats are as follows: ");
//		outPut.println("Strength: " +getStr());
//		outPut.println("Intelligence: " + getIntelli());
//		outPut.println("Dexterity: " + getDex());
//		outPut.println("Constiution: " + getConsti());
//		outPut.println("Charisma: " + getCharisma());
//		outPut.println("Wisdom: " + getWis());
//		outPut.close();
//	}catch(Exception e){
//		System.out.println("Error found");
//	}
//	}
}
