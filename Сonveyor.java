package mrzvis;

public class Сonveyor {
    protected Binary[] a, b;
    protected int r = 6, scope, rang;
    protected Tact[] tacts;

    public Сonveyor( int[] a, int[] b )
    {
        Binary[] first = new Binary[3];
        Binary[] second = new Binary[3];

        for( int i = 0; i < 3; i++ ){
            first[i] = new Binary(a[i]);
            second[i] = new Binary(b[i]);
        }

        this.a = first;
        this.b = second;

        this.rang = a.length;
        this.scope = calculate_scale();
        this.tacts = new Tact[this.scope];
    }

    public int calculate_scale(  )
    {
        int length = this.rang;
        int result = 0;
        if( length == 1 ){
            result = 7;
        }else{
            result = 7 + ( length - 1 )*2;
        }

        return result;
    }

    public Tact getTact( int index )
    {
        return this.tacts[index];
    }

    public void start()
    {
        for( int i = 0; i < this.scope; i++ ){
            this.tacts[i] = tact(i);
        }
    }

    public Tact tact( int index )
    {
        int tact = index + 1;
        switch ( tact ){
            case 1:
                return tact_1();
            case 2:
                return tact_2();
            case 3:
                return tact_3();
            case 4:
                return tact_4();
            case 5:
                return tact_5();
            case 6:
                return tact_6();
            case 7:
                return tact_7();
            case 8:
                return tact_8();
            case 9:
                return tact_9();
            case 10:
                return tact_10();
            case 11:
                return tact_11();
        };

        return null;
    }

    public Tact tact_1()
    {
        Method[] methods = new Method[1];
        methods[0] = new Method( this.a[0], this.b[0] ).multiplication(0);

        Tact tact = new Tact( methods );
        tact.print();

        return tact;
    }

    public Tact tact_2()
    {
        Method[] methods = new Method[2];
        methods[0] = new Method(this.a[0], this.b[0]).multiplication(1);

        Binary binary = getTact( 0 ).getStage(0);
        methods[1] = new Method(binary).sum();

        Tact tact = new Tact( methods );
        tact.print();

        return tact;
    }

    public Tact tact_3()
    {
        Method[] methods = new Method[3];
        Binary[] binaries = new Binary[2];

        methods[0] = new Method( this.a[1], this.b[1] ).multiplication(0);

        binaries[0] = getTact( 1 ).getStage(0);
        binaries[1] = getTact( 1 ).getStage(1);

        methods[1] = new Method( binaries ).sum(1);

        methods[2] = new Method( this.a[0], this.b[0] ).multiplication(2);

        Tact tact = new Tact( methods );
        tact.print();

        return tact;
    }

    public Tact tact_4()
    {
        Method[] methods = new Method[4];
        Binary[] binaries = new Binary[2];

        methods[0] = new Method( this.a[1], this.b[1] ).multiplication(1);

        Binary binary = getTact( 2 ).getStage(0);
        methods[1] = new Method(binary).sum();

        methods[2] = new Method( this.a[0], this.b[0] ).multiplication(3);

        binaries[0] = getTact( 2 ).getStage(2);
        binaries[1] = getTact( 2 ).getStage(1);

        methods[3] = new Method( binaries ).sum(2);

        Tact tact = new Tact( methods );
        tact.print();

        return tact;
    }

    public Tact tact_5()
    {
        Method[] methods = new Method[5];
        Binary[] binaries = new Binary[2];

        methods[0] = new Method( this.a[2], this.b[2] ).multiplication(0);

        binaries[0] = getTact( 3 ).getStage(0);
        binaries[1] = getTact( 3 ).getStage(1);

        methods[1] = new Method(binaries).sum(1);

        methods[2] = new Method( this.a[1], this.b[1] ).multiplication(2);

        binaries[0] = getTact( 3 ).getStage(2);
        binaries[1] = getTact( 3 ).getStage(3);

        methods[3] = new Method( binaries ).sum(3);

        methods[4] = new Method( this.a[0], this.b[0] ).multiplication(4);

        Tact tact = new Tact( methods );
        tact.print();

        return tact;
    }

    public Tact tact_6()
    {
        Method[] methods = new Method[6];
        Binary[] binaries = new Binary[2];

        methods[0] = new Method( this.a[2], this.b[2] ).multiplication(1);


        Binary binary = getTact( 4 ).getStage(0);
        methods[1] = new Method(binary).sum();

        methods[2] = new Method( this.a[1], this.b[1] ).multiplication(3);

        binaries[0] = getTact( 4 ).getStage(2);
        binaries[1] = getTact( 4 ).getStage(1);
        methods[3] = new Method( binaries ).sum(2);

        methods[4] = new Method( this.a[0], this.b[0] ).multiplication(5);

        binaries[0] = getTact( 4 ).getStage(4);
        binaries[1] = getTact( 4 ).getStage(3);
        methods[5] = new Method( binaries ).sum(4);

        Tact tact = new Tact( methods );
        tact.print();

        return tact;
    }

    public Tact tact_7()
    {
        Method[] methods = new Method[5];
        Binary[] binaries = new Binary[2];

        binaries[0] = getTact( 5 ).getStage(0);
        binaries[1] = getTact( 5 ).getStage(1);
        methods[0] = new Method(binaries).sum(1);

        methods[1] = new Method( this.a[2], this.b[2] ).multiplication(2);

        binaries[0] = getTact( 5 ).getStage(2);
        binaries[1] = getTact( 5 ).getStage(3);
        methods[2] = new Method( binaries ).sum(3);

        methods[3] = new Method( this.a[1], this.b[1] ).multiplication(4);

        binaries[0] = getTact( 5 ).getStage(4);
        binaries[1] = getTact( 5 ).getStage(5);
        methods[4] = new Method( binaries ).sum(5);

        Tact tact = new Tact( methods, 1 );
        tact.print();

        return tact;
    }

    public Tact tact_8()
    {
        Method[] methods = new Method[4];
        Binary[] binaries = new Binary[2];

        methods[0] = new Method( this.a[2], this.b[2] ).multiplication(3);

        binaries[0] = getTact( 6 ).getStage(2);
        binaries[1] = getTact( 6 ).getStage(1);
        methods[1] = new Method( binaries ).sum(2);

        methods[2] = new Method( this.a[1], this.b[1] ).multiplication(5);

        binaries[0] = getTact( 6 ).getStage(4);
        binaries[1] = getTact( 6 ).getStage(3);
        methods[3] = new Method( binaries ).sum(4);

        Tact tact = new Tact( methods, 2 );
        tact.print();

        return tact;
    }

    public Tact tact_9()
    {
        Method[] methods = new Method[3];
        Binary[] binaries = new Binary[2];

        binaries[0] = getTact( 7 ).getStage(2);
        binaries[1] = getTact( 7 ).getStage(3);
        methods[0] = new Method( binaries ).sum(3);

        methods[1] = new Method( this.a[2], this.b[2] ).multiplication(4);

        binaries[0] = getTact( 7 ).getStage(4);
        binaries[1] = getTact( 7 ).getStage(5);
        methods[2] = new Method( binaries ).sum(5);

        Tact tact = new Tact( methods, 3 );
        tact.print();

        return tact;
    }

    public Tact tact_10()
    {
        Method[] methods = new Method[2];
        Binary[] binaries = new Binary[2];

        methods[0] = new Method( this.a[2], this.b[2] ).multiplication(5);

        binaries[0] = getTact( 8 ).getStage(4);
        binaries[1] = getTact( 8 ).getStage(3);
        methods[1] = new Method( binaries ).sum(4);

        Tact tact = new Tact( methods, 4 );
        tact.print();

        return tact;
    }

    public Tact tact_11()
    {
        Method[] methods = new Method[1];
        Binary[] binaries = new Binary[2];

        binaries[0] = getTact( 9 ).getStage(4);
        binaries[1] = getTact( 9 ).getStage(5);
        methods[0] = new Method( binaries ).sum(5);

        Tact tact = new Tact( methods, 5 );
        tact.print();

        return tact;
    }

}
