package mrzvis;

public class Binary {

    protected int r = 6;
    protected int[] binary;

    public Binary( int number )
    {
        this.binary = toBinary(number);
    }

    public Binary()
    {
        this(0);
    }

    public Binary( int[] number )
    {
        int r = this.r;
        int[] result = new int[r];

        for( int i = r - 1; i >= 0; i-- ){
            result[i] = number[i];
        }
        this.binary = result;
    }

    protected int[] toBinary( int number )
    {
        int r = this.r;

        int index = r - 1;
        String binaryCode = Integer.toBinaryString(number);
        int[] binary = new int[r];

        for( int i = binaryCode.length() - 1; i >= 0; i-- )
        {
            binary[index--] = Character.getNumericValue( binaryCode.charAt(i) );
        }

        while( index == 0 )
        {
            binary[index--] = 0;
        }

        return binary;
    }

    public int[] getBinary() {
        return this.binary.clone();
    }

    public Binary multiplicateOnInt( int number )
    {
        int r = this.r;
        int[] f = getBinary();

        for( int i = 0; i < r; i++ ){
            f[i] = number * f[i];
        }

        return new Binary(f);
    }

    protected int getInt()
    {
        String binaryString = getString();

        int result = Integer.parseInt(binaryString,2);

        return result;
    }

    protected String getString()
    {
        String binaryString="";
        int r = this.r, result;
        int[] binary = getBinary();

        for( int i = 0; i < r; i++ )
        {
            binaryString += binary[i];
        }

        return binaryString;
    }

    public void print()
    {
        int[] number = getBinary();
        int r = this.r;

        for( int i = 0 ; i < r; i++ )
        {
            System.out.print(number[i]);
        }
        System.out.println();
    }

    public void print( String str )
    {
        System.out.print(str+ " ");
        print();
    }

    public Binary add( Binary binary )
    {
        int r = this.r;
        int temp = 0;
        int[] result = new Binary().getBinary();

        int[] first = getBinary(), second = binary.getBinary();

        for( int i = r - 1; i >= 0; i-- ){
            switch ( first[i] + second[i] ){
                case 0:
                    if( temp == 0 ){
                        result[i] = 0;
                    }else{
                        temp--;
                        result[i] = 1;
                    }
                    break;
                case 1:
                    result[i] = 1;
                    break;
                case 2:
                    result[i] = 1;
                    temp++;
                    break;
            }
        }

        return new Binary(result);
    }

    public Binary addAndSave( Binary binary )
    {
        this.binary = add( binary ).getBinary();
        return this;
    }

    protected Binary shiftLeft( int pos )
    {
        int r = this.r;
        int[] result = new Binary().getBinary();
        int[] current = this.binary;

        for( int i = r - 1; i - pos >= 0 ; i-- ){
            result[i-pos] = current[i];
        }

        this.binary = result;
        return this;
    }

    public int getBit( int index )
    {
        return getBinary()[index];
    }

    public int getBitFromEnd( int index )
    {
        int r = this.r - 1;
        return getBit( r-index );
    }

}
