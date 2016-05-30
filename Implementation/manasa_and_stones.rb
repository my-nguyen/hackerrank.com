# version 3: call Array#uniq to save array memory footprint
def last_stone(stones, a, b)
  # in case a == b and stones == 2
  array = [a]
  if a != b
    array << b
  end

  (stones-2).times do
    # array.length remains constant even though a new element is added into
    # array at each iteration
    array.length.times do |index|
      array << array[index] + a
      array[index] += b
    end

    # calling uniq() saves huge amount of space, and uniq() is fast too!
    # without uniq, the array doubles in size at each iteration.
    # with uniq, the array's size only increases by 1 at each iteration.
    array.uniq!
  end
  return array
end

gets.to_i.times do
  last_stone(gets.to_i, gets.to_i, gets.to_i).sort.each do |element|
    print("#{element} ")
  end
  puts
end
