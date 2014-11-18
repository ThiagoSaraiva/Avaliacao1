package utfpr.ct.dainf.if62c.avaliacao;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná
 * DAINF - Departamento Acadêmico de Informática
 * IF62C - Fundamentos de Programação 2
 * 
 * Primeira avaliação parcial 2014/2.
 * @author 
 */
public class Complexo {
    private double real;
    private double img;

    public Complexo() {
    }

    public Complexo(double real, double img) {
        // completar a implementação
        this.real = real;
        this.img = img;
    }

    // implementar getReal()
    public double getReal() {
        return real;
    }
    
    // implementar getImg()
    public double getImg() {
        return img;
    }

    public Complexo soma(Complexo c) {
        return new Complexo(getReal() + c.getReal(), getImg() + c.getImg());
    }
    
    // implementar sub(Complexo)
    public Complexo sub(Complexo c) {
        return new Complexo(getReal() - c.getReal(), getImg() - c.getImg());
    }

    // implementar prod(double)
    public Complexo prod(double d){
        return new Complexo(getReal() * d, getImg() * d);
    }

    // implementar prod(Complexo)
    public Complexo prod(Complexo c){
        return new Complexo((getReal() * c.getReal() - getImg() * c.getImg()), (getImg() * c.getReal() + getReal() * c.getImg()));
    }
    
    // implementar div(Complexo)
    public Complexo div(Complexo c){
        return new Complexo(((getReal() * c.getReal() + getImg() * c.getImg()) / (c.getReal() * c.getReal() + c.getImg() * c.getImg())), ((c.getReal() * getImg() - getReal() * c.getImg()) / (c.getReal() * c.getReal() + c.getImg() * c.getImg())));
    }
    
    // implementar sqrt()
    public Complexo[] sqrt() {
        // completar implementação
        // retornar o vetor contendo as raízes
        double a1 = getReal();
        double b1 = getImg();
        double r = Math.sqrt(a1 * a1 + b1 * b1);
        double ro = Math.sqrt(r);
        double psi1, psi2, fi = 0;
        
        if(a1 > 0){
            fi = Math.atan(b1 / a1);
        }
        if(a1 < 0){
            fi = Math.atan(b1 / a1) + Math.PI;
        }
        if(a1==0 && b1==0){
            fi = 0;
        }
        if(a1==0 && b1>0){
            fi = (Math.PI) / 2;
        }
        if(a1==0 && b1<0){
            fi = (3 * (Math.PI)) / 2;
        }
        
        psi1 = fi / 2;
        psi2 = fi / 2 + Math.PI;
        Complexo[] c = new Complexo[2];
        
        c[0] = new Complexo(ro * (Math.cos(psi1)), (Math.sin(psi1)));
        c[1] = new Complexo(ro * (Math.cos(psi2)), (Math.sin(psi2)));
        
        return c;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (int) (Double.doubleToLongBits(getReal())
            ^ (Double.doubleToLongBits(getReal()) >>> 32));
        hash = 41 * hash + (int) (Double.doubleToLongBits(getImg())
            ^ (Double.doubleToLongBits(getImg()) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        final Complexo c = (Complexo) obj;
        return obj != null && getClass() == obj.getClass()
            && getReal() == c.getReal() && getImg() == c.getImg();
    }

    @Override
    public String toString() {
        return String.format("%+f%+fi", getReal(), getImg());
    }   
}
