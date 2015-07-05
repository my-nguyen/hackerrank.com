# version 1: solved the partitioning problem, but still couldn't figure out
# how to print the entire array every time a partition is complete, because
# the process method only receives as parameter a section of the original array
# and doesn't have access to the whole array.
def imprimer(array)
  array.each do |element|
    print("#{element} ")
  end
  puts
end

def process(array)
  if (array.length <= 1)
    return array
  else
    pivot = array.length-1
    left = 0
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
    if array[left] > array[pivot]
      array[left], array[pivot] = array[pivot], array[left]
      pivot = left
      imprimer(array)
      imprimer($data)
    end

    return process(array[0..pivot-1]) + [array[pivot]] + process(array[pivot+1..array.length-1])
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
$data = gets.split.map {|i| i.to_i}
array = process($data)
puts("line #{__LINE__}, array: #{array}")
