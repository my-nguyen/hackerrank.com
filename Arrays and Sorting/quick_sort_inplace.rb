# version 2:
def imprimer(array, left=0, right=array.length-1)
  puts("imprimer, left: #{left}, right: #{right}")
  (0..right).each do |index|
    print("#{array[index]} ")
  end
  puts
end

def process(array, left=0, pivot=array.length-1)
  imprimer(array, left, pivot)
  # puts("array.length: #{array.length}")
# def process(array)
=begin
  imprimer(array, left, pivot)
  if (left == 0 && pivot == -1)
    exit 1
  end
=end
  if (pivot - left <= 1)
    return array
  else
    # pivot = array.length-1
    # left = 0
    right = pivot-1
    while (true)
      # moving from left to right, look for a bigger element than that at pivot
      while (left < right && array[left] <= array[pivot])
        left += 1
      end

      # if these 2 indices cross, we're done
      if left >= right
        break
      else
        # moving from right to left, look for a smaller element than that at pivot
        while (right > left && array[right] > array[pivot])
          right -= 1
        end
        # if these 2 indices cross, we're done
        if right <= left
          break
        else
          # if they don't cross then swap the 2 values bigger and smaller
          # and repeat the cycle
          array[left], array[right] = array[right], array[left]
          left += 1
          right -= 1
        end
      end
    end
    old = pivot
    if array[left] > array[pivot]
      array[left], array[pivot] = array[pivot], array[left]
      puts("swapping #{array[left]} and #{array[pivot]}")
      pivot = left
      # imprimer(array)
    end

    puts("pivot: #{pivot}, array.length: #{array.length}")
    return process(array, 0, pivot-1) + [array[pivot]] + process(array, pivot+1, old)
    # return process(array[0..pivot-1]) + [array[pivot]] + process(array[pivot+1..array.length-1])
    # return process(array, 0, middle-1) + [array[middle]] + process(array, middle+1, pivot)
=begin
    gauche = process(array[0..pivot-1])
    puts("line #{__LINE__}, array: #{array}")
    milieu = [array[pivot]]
    droit = process(array[pivot+1..array.length-1])
    puts("line #{__LINE__}, array: #{array}")
    return gauche + milieu + droit
=end
  end
end

array_size = gets.to_i
array = gets.split.map {|i| i.to_i}
# array = process(array, 0, array.length-1)
array = process(array)
imprimer(array)
