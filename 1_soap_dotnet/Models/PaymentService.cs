using System.Text.Json;
namespace Models {
    public class PaymentService:IPaymentService
    {
        private Dictionary<string, float> balance = new Dictionary<string, float>();
        public string totalBalance(){
            return JsonSerializer.Serialize( balance );
        }
        public string personBalance(string uid){
            return JsonSerializer.Serialize( balance[uid] );
        }
        public string addTransaction(float price, string payer, List<string>debtors){
            transact(payer, price * (debtors.Count())/(debtors.Count()+1));
            foreach (string user in debtors){
                transact(user, price* -1/(debtors.Count()+1));
            }
            return "payment added succesfully";
        }

        public string pay(float payment, string payer, string payee){
            transact(payer, payment);
            transact(payee, payment*-1);
            return "paid " + payment + " from " + payer + " to " + payee;
        }

        private void transact(string user,float value){
            if(balance.ContainsKey(user)){
                balance[user] = balance[user] + value;
            }else{
                balance[user] = value;
            }
        }
    }
}