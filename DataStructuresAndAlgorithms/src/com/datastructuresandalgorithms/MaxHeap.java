package com.datastructuresandalgorithms;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap<T extends Comparable<T>> {
    private List<T> container;

    public MaxHeap() {
        container = new ArrayList<>();
    }

    public void add(T element) {
        container.add(element);
        if (container.size() == 1) {
            // we added root so we do not need to percolate up
            return;
        }
        percolate(container.size() - 1);
    }

    public T getMax() {
        if (container.isEmpty()) return null;
        return container.get(0);
    }

    public void replace(T element, int position) {
        if(position >= container.size()) {
            return;
        }
        T currentValue = container.get(position);
        container.set(position, element);
        if (currentValue.compareTo(element) > 0) {
            siftDown(position);
        } else {
            percolate(position);
        }
    }

    /**
     * This method sifts up the value until it reaches the
     * heap property
     * @param fromPosition
     */
    private void percolate(int fromPosition) {
        boolean heapPropertyMet = false;
        while(!heapPropertyMet) {
            int parentPosition = (fromPosition / 2);
            if (fromPosition == 0 || container.get(parentPosition).compareTo(container.get(fromPosition)) >= 0) {
                // heap property condition met
                heapPropertyMet = true;
            } else {
                // swap
                T temp = container.get(parentPosition);
                container.set(parentPosition, container.get(fromPosition));
                container.set(fromPosition, temp);
                fromPosition = parentPosition;
            }
        }
    }


    /**
     * This method sifts down the value until it reaches the
     * heap property
     * @param fromPosition
     */
    private void siftDown(int fromPosition) {
       int sizeOfContainer = container.size();
       while (true) {
           int positionToBeSwapped = -1;
           // check the bounds of the left and right child
           if (2 * fromPosition < sizeOfContainer && (2 * fromPosition) + 1 < sizeOfContainer) {
               // check which one is bigger
               if (container.get(2 * fromPosition).compareTo(container.get((2 * fromPosition) + 1 )) > 0) {
                   // left child is bigger
                   positionToBeSwapped = 2 * fromPosition;
               } else {
                   // right child is bigger
                   positionToBeSwapped = (2 * fromPosition) + 1;
               }
           } else if (2 * fromPosition < sizeOfContainer && (2 * fromPosition) + 1 >= sizeOfContainer) {
               positionToBeSwapped = 2 * fromPosition;
           } else if (2 * fromPosition >= sizeOfContainer && (2 * fromPosition) + 1 < sizeOfContainer){
               positionToBeSwapped = (2 * fromPosition) + 1;
           } else {
               // heapproperty achieved
               break;
           }
           T temp = container.get(fromPosition);
           container.set(fromPosition, container.get(positionToBeSwapped));
           container.set(positionToBeSwapped, temp);
           fromPosition = positionToBeSwapped;
       }
    }

}
