# Version 0.21
import discord
from discord.ext import commands
client = commands.Bot(command_prefix='/', intents=discord.Intents.all())

@client.event  # Console_Log; Shield Active
async def on_ready():
    await client.change_presence(status=discord.Status.online, activity=discord.Game('Watching 1 Server'))
    print("Bartho W")
    print("SHIELD Active")
    print("-----------------------------")
#--------------------------------------------------------------------------------------------------------------
@client.command()  # Purchase
async def purchase(ctx):
    await ctx.send("DM <@1014063161080561684> for purchase inquires.")
#--------------------------------------------------------------------------------------------------------------
@client.command()  # Info
async def info(ctx):
    await ctx.send(
        "Hey I'm Shield\nI am still not complete, I am made with Python by"
        " <@1014063161080561684> & <@324259536192012298>")
#--------------------------------------------------------------------------------------------------------------
@client.command()  # Clear
async def clear(ctx, amount=5):
    await ctx.channel.purge(limit=amount)
#--------------------------------------------------------------------------------------------------------------
@client.command()  # kick
@commands.has_permissions(kick_members=True)
async def kick(ctx, member: discord.Member, *, reason=None):
    await member.kick(reason=reason)
    await ctx.send(f'{member.mention} has been kicked')
#--------------------------------------------------------------------------------------------------------------
@client.command()  # Ban
@commands.has_permissions(ban_members=True)
async def ban(ctx, member: discord.Member, *, reason=None):
    await member.ban(reason=reason)
    await ctx.send(f'{member.mention} has been banned')
#--------------------------------------------------------------------------------------------------------------
@client.command()  # Unban / needs work
@commands.has_permissions(ban_members=True)
async def unban(ctx, *, member):
    banned_users = await ctx.guild.bans()
    member_name, member_discriminator = member.split('#')
    for ban_entry in banned_users:
        user = ban_entry.user
        if (user.name, user.discriminator) == (member_name, member_discriminator):
            await ctx.guild.unban(user)
            await ctx.send(f'Unbanned {user.mention}')
            return
#--------------------------------------------------------------------------------------------------------------
@client.event # Gives SHIELD | Member role on join
async def on_member_join(member):
    welcome_channel = client.get_channel(1029981408615215106)
    role = discord.utils.get(member.guild.roles, id=1029987629044867074)
    await member.add_roles(role)
#--------------------------------------------------------------------------------------------------------------
@client.command()  # Command to write out rules
async def rules(ctx):
    harassment = discord.Embed(title="No Racism or Harassment",
                               description="SHIELD development has a ZERO TOLERANCE policy for any "
                                           "racism/discrimination, personal harassment, sexual harassment, bullying, "
                                           "and abuse of authority. Failure to adhere to our policies set forth below "
                                           "will result in full immediate global removal from all SHIELD Discord "
                                           "servers, websites, and resources WITHOUT REFUND.",
                               colour=discord.Colour.red())
    ad = discord.Embed(title="Advertising",
                       description="No advertising within our server in any chats. This includes Discord servers, "
                                   "social medias, livestreams, etc. ",
                       colour=discord.Colour.red())
    personal = discord.Embed(title="Personal Threat to Life",
                             description="Any activity that may endanger your life or lead to your physical harm "
                                         "is prohibited. This includes, but is not limited to: suicide threats, "
                                         "intentional physical trauma, illegal use of drugs, illegal or dangerous "
                                         "consumption of alcohol, and dangerous or distracted driving. We do not "
                                         "make exceptions for self destructive behavior performed as a stunt or "
                                         "gag made in jest, or meant to entertain, when the behavior could "
                                         "reasonably be expected to cause physical injury.",
                             colour=discord.Colour.red())
    legal = discord.Embed(title="Legal",
                          description="You must respect all applicable local, national, and international laws while "
                                      "using our services. Any content or activity featuring, encouraging, offering, "
                                      "or soliciting illegal activity is prohibited.",
                          colour=discord.Colour.red())
    unauthorized = discord.Embed(title=" Unauthorized Sharing of Private Information",
                                 description="Do not invade the privacy of others. It is prohibited to share "
                                             "content that may reveal private personal information about "
                                             "individuals, or their private property, without permission. This "
                                             "includes but is not limited to: Sharing personally identifiable "
                                             "information (such as real name, location, ID, passport, etc), "
                                             "Sharing restricted or protected social profiles or any information "
                                             "from those profiles, Sharing content that violates another’s "
                                             "reasonable expectation of privacy, for example, "
                                             "sharing someone's address ",
                                 colour=discord.Colour.red())
    staff = discord.Embed(title="Staff",
                          description="Staff has the final call on all decisions regarding punishment, even though "
                                      "something is not listed here, does not mean you can do it. Use common sense to "
                                      "determine what is appropriate to send within our discords.",
                          colour=discord.Colour.red())

    harassment.set_footer(text='Do not copy rules from this server! Author: Bartho')
    # harassment.set_image(url = 'https://indyme.com/wp-content/uploads/2020/11/alert-icon.png')
    harassment.set_thumbnail(url='https://images.squarespace-cdn.com/content/v1/504779d6e4b0dcecada0fc99/1487873936517-5KGYL2H6N6RWPTC5LCW1/rules1.jpg?format=2500w')

    ad.set_footer(text='Do not copy rules from this server! Author: Bartho')
    # ad.set_image(url = 'https://indyme.com/wp-content/uploads/2020/11/alert-icon.png')
    ad.set_thumbnail(url='https://images.squarespace-cdn.com/content/v1/504779d6e4b0dcecada0fc99/1487873936517-5KGYL2H6N6RWPTC5LCW1/rules1.jpg?format=2500w')

    personal.set_footer(text='Do not copy rules from this server! Author: Bartho')
    # personal.set_image(url = 'https://indyme.com/wp-content/uploads/2020/11/alert-icon.png')
    personal.set_thumbnail(url='https://images.squarespace-cdn.com/content/v1/504779d6e4b0dcecada0fc99/1487873936517-5KGYL2H6N6RWPTC5LCW1/rules1.jpg?format=2500w')

    legal.set_footer(text='Do not copy rules from this server! Author: Bartho')
    # legal.set_image(url = 'https://indyme.com/wp-content/uploads/2020/11/alert-icon.png')
    legal.set_thumbnail(url='https://images.squarespace-cdn.com/content/v1/504779d6e4b0dcecada0fc99/1487873936517-5KGYL2H6N6RWPTC5LCW1/rules1.jpg?format=2500w')

    unauthorized.set_footer(text='Do not copy rules from this server! Author: Bartho')
    # unauthorized.set_image(url = 'https://indyme.com/wp-content/uploads/2020/11/alert-icon.png')
    unauthorized.set_thumbnail(url='https://images.squarespace-cdn.com/content/v1/504779d6e4b0dcecada0fc99/1487873936517-5KGYL2H6N6RWPTC5LCW1/rules1.jpg?format=2500w')

    staff.set_footer(text='Do not copy rules from this server! Author: Bartho')
    # staff.set_image(url = 'https://indyme.com/wp-content/uploads/2020/11/alert-icon.png')
    staff.set_thumbnail(url='https://images.squarespace-cdn.com/content/v1/504779d6e4b0dcecada0fc99/1487873936517-5KGYL2H6N6RWPTC5LCW1/rules1.jpg?format=2500w')

    # anyembedname.set_author(text='name')
    # anyembedname.set_footer(text='footer text')
    # anyembedname.set_image(url = 'big image at bottom of embed')
    # anyembedname.set_thumbnail(url='image in the corner')

    await ctx.send(embed=harassment)
    await ctx.send(embed=ad)
    await ctx.send(embed=personal)
    await ctx.send(embed=legal)
    await ctx.send(embed=unauthorized)
    await ctx.send(embed=staff)
#--------------------------------------------------------------------------------------------------------------
@client.event
async def on_message(message):  # Error area: When I add this whole command all other commands stop working, if I remove this commands work again
                                                    
        if message.author == client.user:
            return
        if message.content.find == 'buy':
            await message.channel.send('You can check the pricing of this bot in <#1031324968824356924> &you can always DM <@1014063161080561684> with any questions!')

#-------------------------------------------------------------------------------------------------------------- LEAVE ALONE BELOW
@client.command()  # Shutdown
@commands.has_permissions(administrator=True)
async def shutdown(ctx):
    await ctx.send("<@&1029981619387375687>")
    shield_status = discord.Embed(title="SHIELD Status", 
                                  description="<@&1030671318598819924> is going offline, monitor all channels closely.", colour=discord.Colour.red())
    await ctx.send(embed=shield_status)
    exit()

