public class Party implements Cloneable
{
    private int id, coalition, votes;
    private String name;
    private String logo;
    private VotesHandler handler;
    
    public Party(VotesHandler handler, Coalition coalition, String name, String logo, int votes)
    {
        this.handler = handler;
        this.id = handler.regParty(this);
        this.coalition = coalition.getId();
        this.name = name;
        this.logo = logo;
        this.votes = votes;
        coalition.addParty(this);
    }
    
    public int getId()              { return id; }
    public int getCoalition()       { return coalition; }
    public int getVotes()           { return votes; }
    public String getName()         { return name; }
    public String getLogo()         { return logo; }
    public float getPercentage()    { return handler.getPercentage(this); }
    
    public void setVotes(int votes) { this.votes = votes; }
    public void incrVotes()         { votes++; }
    
    public Party makeClone() throws CloneNotSupportedException
    {
        return (Party)(this.clone());
    }
}