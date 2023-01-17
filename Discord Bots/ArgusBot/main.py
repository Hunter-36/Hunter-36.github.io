import discord
from discord.ext import commands
from discord.utils import get
import time

bot = commands.Bot(command_prefix='/', intents=discord.Intents.all())


@bot.event  # Console_Log; Argus Active
async def on_ready():
    await bot.change_presence(status=discord.Status.online,
                              activity=discord.Activity(type=discord.ActivityType.watching, text="the server"))
    print("Argus Active")
    print("-----------------------------")


@bot.event  # Welcome message and Guest role
async def on_member_join(member):
    role = get(member.guild.roles, id=1049222633255866368)
    await member.add_roles(role)
    channel = bot.get_channel(1050538802378199060)
    await channel.send(
        f"Hello {member.mention} welcome to __**Kingdom 2997, Legion of Fallen**__! First off, please change your "
        f"nickname to match your in game account name. Second if your in Kingdom 2997 head over to "
        f"<#1049223633899360266> and get yourself verified! Third, if you are not from 2997 and are looking to "
        f"migrate here please head over to <#1050535320552222730>. Lastly, if your just here as a friend, have fun!")


@bot.event
async def on_message(message):
    if message.author.bot : return
    if message.content.startswith("/ping"):
        time.sleep(1)
        await message.delete()
    await bot.process_commands(message)


@bot.command()  # Just pings the bot
async def ping(ctx):
    await ctx.send(f'My ping is {bot.latency}!')


@bot.command()  # Clear messages
async def purge(ctx, amount=5):
    await ctx.channel.purge(limit=amount)


@bot.command()  # Locks down the channel
@commands.has_permissions(manage_channels=True)
async def shutdown(ctx):
    await ctx.channel.set_permissions(ctx.guild.default_role,send_messages=False)
    await ctx.send( ctx.channel.mention + " ***is now in lockdown, staff will reopen shortly.***")


@bot.command()  # Unlocks the channel
@commands.has_permissions(manage_channels=True)
async def reopen(ctx):
    await ctx.channel.set_permissions(ctx.guild.default_role, send_messages=True)
    await ctx.send(ctx.channel.mention + " ***has been unlocked, have fun!***")


@bot.command()  # Shutdown
@commands.has_permissions(administrator=True)
async def kill(ctx):
    await ctx.send("<@&1049219382477340702>")
    argus_status = discord.Embed(title="Argus Status",
                                 description="Argus is going offline, monitor all channels closely.",
                                 colour=discord.Colour.red())
    await ctx.send(embed=argus_status)
    exit()


#  invite link
# https://discord.com/api/oauth2/authorize?client_id=1050637553730068550&permissions=8&scope=bot    












































# keep hidden
bot.run('MTA1MDYzNzU1MzczMDA2ODU1MA.Gi3j8P.Cf4ibw6hesYg2JMbrWoezP4idOo9IzngBQ_5gE')
