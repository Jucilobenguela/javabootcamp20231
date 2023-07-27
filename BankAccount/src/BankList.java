public enum BankList {
    CGD(1,"Caixa Geral de Depósito"),
    BANCOBPI(2,"Banco BPI"),
    BANCOMONTEPIO(3,"Banco Montepio"),
    NOVOBANCO(4,"Novo Banco"),
    MILLENNIUM(5,"Millennium");
    private final String nameBank;
    private final int idBank;

    BankList(int bankId, String bankOption)
    {
        idBank=bankId;
        nameBank=bankOption;

    }
    public int getIdBank()
    {
        return idBank;
    }
   public String getNameBank()
   {
       return nameBank;

   }


}
