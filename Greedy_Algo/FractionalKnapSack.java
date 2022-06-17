import java.util.*;

class Item {
    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

class itemC implements Comparator<Item> {
    public int compare(Item a, Item b) {
        double r1 = (double) (a.value) / (double) (a.weight);
        double r2 = (double) (b.value) / (double) (b.weight);

        if (r1 < r2) {
            return 1;
        } else if (r1 > r2) {
            return -1;
        } else {
            return 0;
        }
    }
}

class Solution {
    double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, new itemC());
        int currWeight = 0;
        double finalVal = 0.0;
        for (int i = 0; i < n; i++) {
            if (currWeight + arr[i].weight <= W) {
                currWeight += arr[i].weight;
                finalVal += arr[i].value;
            } else {
                int remain = W - currWeight;
                finalVal += ((double) arr[i].value / (double) arr[i].weight) * (double) remain;
                break;
            }
        }
        return finalVal;
    }
}

// Time Complexity: O(NlogN)

// Space Complexity: O(1)