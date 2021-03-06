
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

class territory extends Observable {
    ArrayList<territory> neighbors;
    boolean occupied;
    int armies;
    String continent;
    String name;
    String playerName;
    int playerNum;
    RiskObserver observer = new RiskObserver();

    
    
    territory(String name, String continent){
        armies=0;
        neighbors = new ArrayList<>();
        occupied=false;
        this.name=name;
        this.continent=continent;
        addObserver(observer);
    }
        
    public void addArmy(){
        armies++;
    }
    
    public void addArmies(int x){
        armies+=x;
    }
    
    public void deleteArmy(int a){
        armies-=a;
        
    }
    public void addNeighbor(territory a){
        neighbors.add(a);
    }
    public void occupy(){
        occupied=true;
    }
    public ArrayList<Integer> attack(int num){
        ArrayList<Integer> attackNumbers= new ArrayList<>();
        for(int i=0; i<num;i++){
            attackNumbers.add((int)(Math.random()*6)+1);
        }
        
        return attackNumbers;
    }
    public ArrayList<Integer> defend(int num){
        setChanged();
        notifyObservers(getPlayerName());
        ArrayList<Integer> defendNumbers= new ArrayList<>();
        for(int i=0; i<num;i++){
            defendNumbers.add((int)(Math.random()*6)+1);
        }
        return defendNumbers;
    }
    public int numArmies(){
        return armies;
    }
    
    public boolean isOccupied(){
        return occupied;
    }
    
    public void setPlayerNum(int num){
        playerNum=num;
    }
    
    public int getPlayerNum(){
        return playerNum;
    }

    public void setPlayerName(String name){playerName = name;}

    public String getPlayerName(){return playerName;}

    public String getContinent() {
        return continent;
    }

    public String getName() {
        return name;
    }
    
    public boolean isNeighbor(territory a){
        boolean neighbor=false;
        for(int i=0;i<neighbors.size();i++){
            if(a.getName()==neighbors.get(i).getName()){
                neighbor=true;
            }
        }
        
        return neighbor;
    }
}
