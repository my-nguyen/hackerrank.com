def pprocess(array, index)
  value = array[index]
  # starting from left of index, proceed leftward
  i = index - 1
  while (i >= 0 && array[i] > value)
    # shift array[i] one to the right
    array[i+1] = array[i]
    i -= 1
  end
  # insert value into its rightful place
  array[i+1] = value
  # this is the number of shifts made
  return index - (i+1);
end

def process(array)
  sum = 0
  (1..array.length-1).each do |i|
    sum += pprocess(array, i)
  end
  return sum
end

array_size = gets.to_i
array = gets.split.map {|i| i.to_i}
puts(process(array))
