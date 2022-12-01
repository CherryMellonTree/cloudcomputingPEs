using System.ServiceModel;
namespace Models
{
    [ServiceContract]
    public interface IPaymentService
    {
        [OperationContract]
        string totalBalance();
        [OperationContract]
        string personBalance(string uid);
        [OperationContract]
        string addTransaction(float price, string payer,List<string> debtors);
        [OperationContract]
        string pay(float payment, string payer, string payee);
    }
}