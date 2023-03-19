package MVC.model;

public class Cart extends Product{
    private double totalMoney;
    private int quantityProduct;

    public int getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(int quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }


    public Cart() {
    }

    public Cart(Product product, double totalMoney, int quantityProduct) {
        this.totalMoney = totalMoney;
        this.quantityProduct = quantityProduct;
    }

    public void incrementQuantity(int quantity)
    {
        this.quantityProduct++;
    }



//    private List<Item> items;

//    public Cart(List<Item> items) {
//        this.items = items;
//    }
//
//    public List<Item> getItems() {
//        return items;
//    }
//    public void setItems(List<Item> items) {
//        this.items = items;
//    }
//
//    public int getQuantityById(int id)
//    {
//        return getItemById(id).getQuantity();
//    }
//    public Item getItemById(int id)
//    {
//        for(Item i:items)
//        {
//            if(i.getProduct().getId() == id)
//            {
//                return  i;
//            }
//        }
//        return null;
//    }
//
//    public void addItem(Item item)
//    {
//        if(getItemById(item.getProduct().getId()) != null)
//        {
//            Item m = getItemById(item.getProduct().getId());
//            m.setQuantity(m.getQuantity() + item.getQuantity());
//        }else
//        {
//            items.add(item);
//        }
//    }
//
//     public void removeItem(int id)
//     {
//         if(getItemById(id) != null)
//         {
//             items.remove(getItemById(id));
//         }
//     }
//
//     public double getTotalMoney()
//     {
//         double t = 0 ;
//         for(Item i:items)
//         {
//             t += i.getQuantity()* i.getPrice();
//         }
//
//         return t;
//     }


}
