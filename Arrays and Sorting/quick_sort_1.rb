def process(array)
  p = array.first
  lower = []
  i = 1
  while (i < array.length)
    if (array[i] < p)
      # copy the smaller element to the "lower" array
      lower << array[i]
      # remove the smaller element from current array
      array.delete_at(i)
    else
      i += 1
    end
  end
  # the result is the combination of the lower and the current array
  return lower + array
end

array_size = gets.to_i
array = gets.split.map {|i| i.to_i}
process(array).each do |element|
  print("#{element} ")
end
puts
