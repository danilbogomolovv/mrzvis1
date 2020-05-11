package mrzvis;

public class Method {
    protected Binary first, second, result;

    public Method( Binary first, Binary second )
    {
        this.first = first;
        this.second = second;
    }

    public Method( Binary[] binaries)
    {
        this.first = binaries[0];
        this.second = binaries[1];
    }

    public Method( Binary a )
    {
        this( a, new Binary() );
    }

    public Binary callback()
    {
        return this.result;
    }

    public Method multiplication( int index )
    {

        this.result = this.second.multiplicateOnInt( this.first.getBitFromEnd(index) );
        return this;
    }

    public Method sum( int shift )
    {
        this.result = this.second.addAndSave( this.first.shiftLeft(shift) );
        return this;
    }

    public Method sum()
    {
        return sum(0);
    }

}

