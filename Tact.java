package mrzvis;

public class Tact {

    protected int size = 6;
    protected Binary[] line;

    public Tact( Method[] methods, int offset )
    {
        this.line = init();

        for( int i = 0; i < methods.length; i++  ){
            this.line[i + offset] = methods[i].callback();
        }

    }

    public Tact( Method[] methods )
    {
        this(methods, 0);
    }

    public void print()
    {
        int size = this.size;
        String[] str = new String[size];
        String format = "";
        Binary[] line = this.line;

        for( int i = 0; i < size; i++ ){
            format+="%15s";
            if( line[i] == null ){
                str[i] = "-";
                continue;
            }
            str[i] = line[i].getString();
        }
        System.out.format(format, str[0], str[1], str[2], str[3], str[4], str[5]);
        System.out.println();
    }

    public Binary[] init()
    {
        int size = this.size;
        Binary[] binary = new Binary[size];

        for( int i = 0; i < size; i++ ){
            binary[i] = null;
        }

        return binary;
    }

    public Binary getStage( int index )
    {
        return this.line[index];
    }
}
