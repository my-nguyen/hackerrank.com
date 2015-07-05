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
    pivot = array.shift
    lower = []
    i = 0
    while (i < array.length)
      if (array[i] < pivot)
        # copy the smaller element to the "lower" array
        lower << array[i]
        # remove the smaller element from current array
        array.delete_at(i)
      else
        i += 1
      end
    end

    // assemble the lower, pivot and upper parts. Note the recursive calls
    array = process(lower) + [pivot] + process(array)
    imprimer(array)
    return array
  end
end

array_size = gets.to_i
array = gets.split.map {|i| i.to_i}
process(array)
