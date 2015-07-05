def emprunter(array)
  array.each do |element|
    print("#{element} ")
  end
  puts
end

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
end

def process(array)
  (1..array.length-1).each do |i|
    pprocess(array, i)
    emprunter(array)
  end
end

array_size = gets.to_i
array = gets.split.map {|i| i.to_i}
process(array)
