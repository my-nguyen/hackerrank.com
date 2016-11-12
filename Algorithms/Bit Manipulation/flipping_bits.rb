def flipping_bits(number)
  # first, negate the number
  reverse = ~number
  # next convert the negated number to a 32-bit string
  rbits = 31.downto(0).map { |n| reverse[n] }.join
  # finally convert the 32-bit string back to an integer
  return rbits.to_i(2)
end


gets.strip.to_i.times do
  puts(flipping_bits(gets.strip.to_i))
end
