def maximizing_xor(lower, upper)
  max = 0
  (lower..upper-1).each do |left|
    (left+1..upper).each do |right|
      if max < left^right
        max = left^right
      end
    end
  end
  return max
end

puts(maximizing_xor(gets.to_i, gets_to_i))
