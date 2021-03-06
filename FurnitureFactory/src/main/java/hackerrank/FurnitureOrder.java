package hackerrank;

import java.util.HashMap;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
    HashMap<Furniture,Integer> furnitureMap = new HashMap<>();

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        // TODO: Complete the constructor
        furnitureMap.put(Furniture.CHAIR,0);
        furnitureMap.put(Furniture.COUCH,0);
        furnitureMap.put(Furniture.TABLE,0);
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        // TODO: Complete the method
        if(furnitureMap.containsKey(type)){
            int count = furnitureMap.get(type)+furnitureCount;
            furnitureMap.put(type,count);
        }
        furnitureMap.put(type,furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
        return furnitureMap;
    }

    public float getTotalOrderCost() {
        // TODO: Complete the method
        int quantity; float costChair=0, costCouch=0, costTable=0;
        if(!furnitureMap.isEmpty()){
            for(Furniture furniture : furnitureMap.keySet()){
                quantity = furnitureMap.get(furniture);
                if(Furniture.CHAIR.equals(furniture)){
                    costChair = quantity*Furniture.CHAIR.cost();
                }else if(Furniture.COUCH.equals(furniture)){
                    costCouch = quantity*Furniture.COUCH.cost();
                }else if(Furniture.TABLE.equals(furniture)){
                    costTable = quantity*Furniture.TABLE.cost();
                }
            }

        }

        return costChair+costCouch+costTable;
    }

    public int getTypeCount(Furniture type) {
        // TODO: Complete the method
        if(!furnitureMap.isEmpty()){
            return furnitureMap.get(type);
        }
        return 0;
    }

    public float getTypeCost(Furniture type) {
        // TODO: Complete the method
        if(!furnitureMap.isEmpty()){
            float cost = 0;
            int quantity = furnitureMap.get(type);
            if(Furniture.CHAIR.equals(type) && quantity>0){
                cost = quantity*Furniture.CHAIR.cost();
            }else if(Furniture.COUCH.equals(type)&& quantity>0){
                cost = quantity*Furniture.COUCH.cost();
            }else if(Furniture.TABLE.equals(type)&& quantity>0){
                cost = quantity*Furniture.TABLE.cost();
            }
            return cost;
        }
        return 0.0f;
    }

    public int getTotalOrderQuantity() {
        // TODO: Complete the method
        int quantity = 0;
        if(!furnitureMap.isEmpty()){

            for(Furniture furniture : furnitureMap.keySet()){
                quantity = quantity+ furnitureMap.get(furniture);
            }

        }
        return quantity;
    }
}
